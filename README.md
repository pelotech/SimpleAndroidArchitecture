#Simple Android Architecture
##Why is this here?
To provide some good example patterns to use for android. After helping Nordstrom with a project for interviews we decided to open source to start conversations
around best practices, holes to watch out for, libraries and examples to make life easier.


##Current State
1. It's following an MVVM pattern where view models (presentationmodels from robobinding) carry most of the weight and keep activies and fragments lightweight
2. Has Reactive examples including some test examples
3. Libraries included are - Roboguice, Robobinding, Robolectric, Retrofit, Mockito, etc


##Goals
1. Start a dialog on finding simple solutions to common problems in Android
2. Create a good jumping point for new projects (a la rails?)
3. Help teach new developers good habits
4. Focus on easily changeable code and TDD/BDD
5. Create similar project for iOS for potential cross over principles (j2objc?)


##Notes
Although all the approaches should be able to be applied no matter the sdk. Currently it's going to support 15 and up.


##Still needs help
1. More TDD/BDD examples
2. Add more layout tricks and tips
3. Add some rapid web dev libraries such as Parse
4. Add some examples for A/B feature testing and feature flagging
5. Templatizing the project


##Wanna contribute?
1. Normal fork and pull request :)  Remember to branch ;)
