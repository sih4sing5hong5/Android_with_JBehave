package 臺灣.試驗;


import com.example.android_with_jbehave.加字串;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.assertj.core.api.Assertions.assertThat;


public class 加字串步驟 {

    private 加字串 加字串資料;

    @Given("啟動程式")
    public void 啟動程式() {
        加字串資料 = new 加字串();
    }

    @When("加字串 $字串")
    public void 加字串(String 字串) {
        加字串資料.加新字串(字串);
    }

    @Then("得到長度 $長度")
    public void 得到長度(int 長度) {
        assertThat(加字串資料.全部長度()).isEqualTo(長度);
    }

    @Then("攏總加 $擺 擺")
    public void 攏總加(int 擺) {
        assertThat(加字串資料.全部次數()).isEqualTo(擺);
    }

}
