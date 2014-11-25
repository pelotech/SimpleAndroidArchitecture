package com.liffft.simpleandroidarchitecture.robolectric;

import com.google.inject.AbstractModule;
import com.liffft.simpleandroidarchitecture.model.Repo;
import com.liffft.simpleandroidarchitecture.presentationmodel.RepoListPresentationModel;
import com.liffft.simpleandroidarchitecture.service.ProjectSchedulers;
import com.liffft.simpleandroidarchitecture.service.ProjectService;
import com.liffft.simpleandroidarchitecture.service.Service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.robolectric.Robolectric;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import roboguice.RoboGuice;
import rx.Observable;
import rx.schedulers.Schedulers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by jhill on 11/19/14.
 */
@RunWith(RobolectrictGradleTestRunner.class)
public class RepoListPresentationModelTest {



    ProjectService mockProjectService;
    Service mockService;
    ProjectSchedulers mockSchedulers;
    RepoListPresentationModel repoListPresentationModel;

    @Before
    public void setup() {

        //Setup mock schedulers to be non async
        mockSchedulers = Mockito.mock(ProjectSchedulers.class);
        when(mockSchedulers.getUIScheduler()).thenReturn(Schedulers.immediate());
        when(mockSchedulers.getNewThreadScheduler()).thenReturn(Schedulers.immediate());

        //Setup Dummy data from the Observable
        List<Repo> repos =new ArrayList<Repo>();
        Repo repo = new Repo();
        repo.name = "test1";
        repos.add(repo);
        Observable<List<Repo>> observable = Observable.just(repos);


        //Setup Mock Services
        mockProjectService = Mockito.mock(ProjectService.class);
        mockService = Mockito.mock(Service.class);
        when(mockProjectService.getService()).thenReturn(mockService);
        when(mockService.getRepoList()).thenReturn(observable);

        //Setup Injection
        RoboGuice.overrideApplicationInjector(Robolectric.application, new MyTestModule());
        repoListPresentationModel = RoboGuice.getInjector(Robolectric.application).getInstance(RepoListPresentationModel.class);
    }
    @After
    public void teardown() {
        RoboGuice.Util.reset();
    }

    @Test
    public void testListOfDataByObservable () {
        repoListPresentationModel.subscribeTo();
        assertEquals("test1", repoListPresentationModel.getRepoList().get(0).name);
        repoListPresentationModel.unSubscribeTo();
    }

    public class MyTestModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(ProjectSchedulers.class).toInstance(mockSchedulers);
            bind(ProjectService.class).toInstance(mockProjectService);
        }
    }
}

