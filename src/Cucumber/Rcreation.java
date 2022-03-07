
package Cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\vamsh\\Seleniumprojectjar\\Ebanking\\src\\Cucumber\\xyz.feature"
                 ,glue="Cucumber",
                 monochrome=true,
                 plugin={"pretty","json:target/reports/login.json"})
public class Rcreation 
{

}
