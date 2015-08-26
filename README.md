# Android專案JBehave設定

配合最近流行的Behaviour-Driven Development(BDD)，
試著讓Android搭配JBehave套件，
希望可以減少大家的摸索時間。


## 執行

[![Build Status](https://travis-ci.org/sih4sing5hong5/Android_with_JBehave.svg)](https://travis-ci.org/sih4sing5hong5/Android_with_JBehave)

本專案已可正常試驗，會得到`BUILD SUCCESSFUL`.

### Android Studio
將`Build variants`的`test artifact`改成`Unit tests`即可。
可以參考[Unit testing support](http://tools.android.com/tech-docs/unit-testing-support)

### 指令
`./gradlew test`

## 套件設定
`app`裡的`build.gradle`是設定gradle以及套件相依設定
在裡面`dependencies`裡加上Junit、JBehave相關套件
```groovy
dependencies {
    ...

    testCompile 'junit:junit:4.12'
    testCompile 'org.mockito:mockito-core:1.10.19'
    testCompile 'org.assertj:assertj-core:1.7.0'
    testCompile 'org.jbehave:jbehave-core:4.0.3'
}
```
若使用Android Studio，更改完請按視窗的`Sync Now`更新gradle相依性。

## 資料目錄
資料都在`app`資料夾裡

* `src/main/java`：Android主要程式
* `src/main/res`：Android設定檔
* `src/test/java`：unit test試驗檔案
* `src/test/resources`：JBehave story檔案
* `src/androidTest/test`：Android試驗

## 一般JUnit試驗
可以參考`src/test/java/臺灣/試驗/JUnit試驗.java`檔。

## JBehave的JUnit試驗
BDD的順序應該為：

1. 寫好Story行為檔
2. 寫好Steps步驟檔，並且執行試驗看步驟是否成功
3. 實作程式，並且執行試驗看看實作是否符合當初的Story行為檔

對應到JBehave的實作順序：

1. 寫好Story行為檔
2. 寫好JBehave的JUnit設定檔，並且執行試驗看設定是否成功
3. 寫好JBehave的Steps步驟檔，並且執行試驗看步驟是否成功
4. 實作程式本身，並且執行試驗看實作是否符合當初的Story行為檔

### 自動搜尋Story（JUnitStories）
java是支援Unicode編碼的，所以package、檔名、型態名、變數、…都可以用漢字。

若我們寫好了三個Story：

* `src/test/resources/臺灣/試驗/加字串次數試驗.story`
* `src/test/resources/臺灣/試驗/加字串長度試驗.story`
* `src/test/resources/臺灣/試驗/加字串完整試驗.story`


接下來寫JUnit設定檔`src/test/java/臺灣/試驗/走全部試驗.java`，
其中`storyPaths`函式定義Story檔的路徑
```java
@Override
protected List<String> storyPaths() {
    return new StoryFinder().findPaths(
            "src/test/resources",
            Collections.singletonList("**/*.story"), // 要執行Story檔名
            null
    );
```
（若只要執行特定路徑的Story，執行Story檔名參數可改成`Collections.singletonList("**/試驗/*.story")`。）

另外也要定義Story每步做什麼事，加上：
* `src/test/java/臺灣/試驗/加字串步驟.java`

並在JUnit設定檔`test/java/臺灣/試驗/走全部試驗.java`引入：
```java
@Override
public InjectableStepsFactory stepsFactory() {
    return new InstanceStepsFactory(configuration(), new 加字串步驟());
}
```
這時候執行試驗，會得到錯誤。

接下來實作程式`src/main/java/com/example/android_with_jbehave/加字串.java`
這樣就能成功執行三個Story了！！

#### 全部檔案
##### Story行為檔
* `src/test/resources/臺灣/試驗/加字串次數試驗.story`
* `src/test/resources/臺灣/試驗/加字串長度試驗.story`
* `src/test/resources/臺灣/試驗/加字串完整試驗.story`

##### 試驗檔案
* `src/test/java/臺灣/試驗/走全部試驗.java`
* `src/test/java/臺灣/試驗/加字串步驟.java`

##### 實作程式
* `src/main/java/com/example/android_with_jbehave/加字串.java`


### 一個Story一個JUnit設定檔（JUnitStory）
若想要對各別Story做不同設定，或是設定不同的步驟（Steps），可以用
若Story放在`src/test/resources`的`臺灣/試驗/`，
則必須在對應路徑`src/test/java/`的`臺灣/試驗/`放一個JUnit設定檔。

為了方便起見，JBehave規定這種方式的JUnit設定檔的檔名必須和Story對應。
若Story叫`加字串長度試驗.story`，
則JUnit設定檔必須叫`加字串長度試驗.java`。

寫好了Story和JUnit設定檔後，再來要定義Story裡每步要做什麼，寫在Steps檔。
若Steps檔叫做`src/test/java/臺灣/試驗/加字串步驟.java`，在JUnit設定檔就必須載入：
```
@Override
public InjectableStepsFactory stepsFactory() {
    // varargs, can have more that one steps classes
    return new InstanceStepsFactory(configuration(), new 加字串步驟());
}
```

總共依序用了以下試驗檔案：

* `src/test/resources/臺灣/試驗/加字串長度試驗.story`
* `src/test/java/臺灣/試驗/加字串長度試驗.java`
* `src/test/java/臺灣/試驗/加字串步驟.java`

和實作程式：

* `src/main/java/com/example/android_with_jbehave/加字串.java`
