package 臺灣.試驗;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.assertj.core.api.Assertions.assertThat;


public class 加字串步驟 {

    private StringBuffer 漢字資料;

    @Given("啟動程式")
    public void 啟動程式() {
        漢字資料=new StringBuffer();
    }

    @When("加字串 $字串")
    public void 加字串(String 字串) {
        漢字資料.append(字串);
    }

    @Then("得到長度 $長度")
    public void theGridShouldLookLike(int 長度) {
        assertThat(漢字資料.toString().length()).isEqualTo(長度);
    }

}
