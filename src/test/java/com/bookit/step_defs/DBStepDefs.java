package com.bookit.step_defs;

import com.bookit.utilities.DBUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.BeforeClass;

import java.util.Map;

public class DBStepDefs {


    Map<String,Object> dbMap;



    @When("User sens a query to DataBase with {string}")
    public void user_sens_a_query_to_DataBase_with(String email) {
        DBUtils.createConnection();

        String query = "select firstname, lastname, role, name,location,batch_number\n" +
                "from users u join (select t.id,name,batch_number,location from\n" +
                "team t join campus c on t.campus_id=c.id) r\n" +
                "on u.team_id=r.id where u.email='"+email+"';";
       dbMap = DBUtils.getRowMap(query);
        System.out.println("dbMap.toString() = " + dbMap.toString());


    }

    @Then("User gets DB info")
    public void user_gets_DB_info() {
        System.out.println("We good");
    }

}
