import models.Campus;
import models.Edital;

import org.junit.Test;

import org.junit.*;

import java.util.*;

import play.mvc.*;
import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

public class ModelTest {
	
	@Test
	public void findById() {
	//  running(fakeApplication(), new Runnable() {
	//    public void run() {
	      Campus natal = Campus.find.byId(1l);
	      assertThat(natal.nome).isEqualTo("Natal - Central");
	//    }
	//  });
	}

}
