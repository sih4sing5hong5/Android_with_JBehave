# Android專案JBehave設定

配合最近流行的Behaviour-Driven Development (BDD)，
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
資料都在`app/src`資料夾裡

* `main/java`：android主要程式
* `main/res`：android設定檔
* `test/java`：unit test試驗檔案
* `test/resources`：JBehave story檔案
* `androidTest/test`：android試驗

## 一般Unit test試驗
可以參考`test/java/com/example/android_with_jbehave/ValidatorTest.java`檔。

## 增加BDD試驗
BDD的實作順序應該為：

1. 寫好Story
2. 寫好JBehave的JUnitSotry設定檔
3. 寫好JBehave的Steps檔
4. 實作程式本身

### 一般試驗
若寫好一個Story，若放在`test/resources`的`com/example/android_with_jbehave/`，
則必須在對應路徑`test/java/`的`com/example/android_with_jbehave/`放一個JUnitSotry設定檔。

為了方便起見，JBehave規定JUnitSotry設定檔的檔名必須和Story對應。
若Story叫`i_can_toggle_a_cell.story`，
則JUnitSotry設定檔必須叫`ICanToggleACell.java`。

實際檔案內容可以參考JBehave的[Getting Started](http://jbehave.org/reference/stable/getting-started.html)。

寫好了Story和JUnitSotry設定檔後，再來要定義Story裡的每一步要做什麼，就是定義在Steps檔。若Steps檔叫做`GridSteps.java`，在JUnitSotry設定檔就必須載入：
```
    @Override
    public InjectableStepsFactory stepsFactory() {
        // varargs, can have more that one steps classes
        return new InstanceStepsFactory(configuration(), new GridSteps());
    }
```

總共新增了以下試驗檔案：

* `test/resources/com/example/android_with_jbehave/i_can_toggle_a_cell.story`
* `test/java/com/example/android_with_jbehave/ICanToggleACell.java`
* `test/java/com/example/android_with_jbehave/GridSteps.java`

和尚末實作的程式：

* `main/java/com/example/android_with_jbehave/Game.java`
* `main/java/com/example/android_with_jbehave/StringRenderer.java`

### 用漢字命名的函式
java是支援unicode編碼的，所以package、型態名、變數、…都可以用漢字。
不過因為JBehave實作的關係（jbehave-core:4.0.3），Story和JUnitSotry設定檔檔名必須英文開頭。

加的程式：
* `test/resources/com/漢字/a漢字試驗.story`
* `test/java/com/漢字/A漢字試驗.java`
* `test/java/com/漢字/漢字步.java`


