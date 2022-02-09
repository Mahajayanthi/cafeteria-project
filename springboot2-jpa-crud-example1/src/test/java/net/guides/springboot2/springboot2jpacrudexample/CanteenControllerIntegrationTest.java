package net.guides.springboot2.springboot2jpacrudexample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import net.guides.springboot2.springboot2jpacrudexample.model.Canteen;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CanteenControllerIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllCanteens() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/canteens",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetCanteenById() {
		Canteen canteen = restTemplate.getForObject(getRootUrl() + "/canteens/1", Canteen.class);
		System.out.println(canteen.getPlace());
		assertNotNull(canteen);
	}

	@Test
	public void testCreateEmployee() {
		Canteen canteen = new Canteen();
		canteen.setId(1);
		
		canteen.setPlace("Tidel Park");
		canteen.setCompanyName("STG Infotech");
		canteen.setPlace("Tidel Park");
		canteen.setDateandtime("07.02.2002,2.30");
		canteen.setPhoneNo(9790950995l);
		canteen.setSelectCanteen("Nakshartha");

		ResponseEntity<Canteen> postResponse = restTemplate.postForEntity(getRootUrl() + "/canteens", canteen, Canteen.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateCanteen() {
		int id = 1;
		Canteen canteen = restTemplate.getForObject(getRootUrl() + "/canteens/" + id, Canteen.class);
		canteen.setId(1);
		//canteen.setMailId("maha@gmail.com");
		canteen.setMailId("mahamothilala13@gmail.com");
		canteen.setPlace("Tidel Park");
		canteen.setDateandtime("07.02.2002,2.30");
		canteen.setPhoneNo(9790950995l);
		canteen.setSelectCanteen("Nakshartha");
		restTemplate.put(getRootUrl() + "/canteens/" + id, canteen);

		Canteen updatedCanteen = restTemplate.getForObject(getRootUrl() + "/canteens/" + id, Canteen.class);
		assertNotNull(updatedCanteen);
	}

	@Test
	public void testDeleteCanteen() {
		int id = 2;
		Canteen canteen = restTemplate.getForObject(getRootUrl() + "/canteens/" + id, Canteen.class);
		assertNotNull(canteen);

		restTemplate.delete(getRootUrl() + "/canteens/" + id);

		try {
			canteen= restTemplate.getForObject(getRootUrl() + "/canteens/" + id, Canteen.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}
