import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import service.ApiService;
import util.SystemProperties;


public abstract class BaseTest {

   static ApiService apiService = new ApiService(SystemProperties.APPLICATION_URL);

}
