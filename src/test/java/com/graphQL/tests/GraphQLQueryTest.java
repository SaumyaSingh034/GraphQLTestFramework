package com.graphQL.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GraphQLQueryTest {

    @Test
    public void getAllFilmsTest(){
        //https://swapi-graphql.netlify.app/.netlify/functions/index

        RestAssured.baseURI ="https://graphql.org";
        String query = "{\"query\": \"{\\nallFilms{\\n  films{\\n    title\\n  }\\n}}\"}";
        given().relaxedHTTPSValidation().log().all()
                .contentType("application/json")
                .body(query)
                .when().log().all()
                .post("/graphql")
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void getAllUsersTest() {
        RestAssured.baseURI ="https://hasura.io";
        String query = "{\"query\":\"{\\n  users(limit: 10) {\\n    id\\n    name\\n  }\\n}\\n\",\"variables\":null}";

        given().log().all()
                .contentType("application/json")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDYwYzYyMzlhNGQ1OTVkMDA2Nzg0NjEzYyJ9LCJuaWNrbmFtZSI6Im5hdmVlbmFuaW1hdGlvbjIwIiwibmFtZSI6Im5hdmVlbmFuaW1hdGlvbjIwQGdtYWlsLmNvbSIsInBpY3R1cmUiOiJodHRwczovL3MuZ3JhdmF0YXIuY29tL2F2YXRhci82MTVjNTVlNjBiZTU2N2ZmMDRiZTBjYTUwMmM5ZWExMz9zPTQ4MCZyPXBnJmQ9aHR0cHMlM0ElMkYlMkZjZG4uYXV0aDAuY29tJTJGYXZhdGFycyUyRm5hLnBuZyIsInVwZGF0ZWRfYXQiOiIyMDIxLTA2LTIyVDA3OjAzOjMzLjgyMFoiLCJpc3MiOiJodHRwczovL2dyYXBocWwtdHV0b3JpYWxzLmF1dGgwLmNvbS8iLCJzdWIiOiJhdXRoMHw2MGM2MjM5YTRkNTk1ZDAwNjc4NDYxM2MiLCJhdWQiOiJQMzhxbkZvMWxGQVFKcnprdW4tLXdFenFsalZOR2NXVyIsImlhdCI6MTYyNDM0NTQxNiwiZXhwIjoxNjI0MzgxNDE2LCJhdF9oYXNoIjoiTENVX1Izc3ZyNXF1ZXFBajJMTXMzQSIsIm5vbmNlIjoiSUdoRHNycDEubG5zMTFQOFlCTHRkMTFKYXR3UVRPZnIifQ.B4ipspXwxiNAP7phKGiUQnhZa_0BPgP53sk9Pbm7trUmoxNhvcp1lJB1mq90mRHmXLZNR-6iy3oqjCgIlKTuywpM__ncdx_VAbDtyjgMJyxU6N5VTClxJrN8Hb_q5sZ3i7q322OGRxdYCM_lNivu0HBwyRrtu09DXp_QFHIwJp6gt6k28dulSut7KBmms_sJKxJAsI6T2b-UBcMwaXTnJXB-j7d-ofubwfX8ZNwo5GgOtUPtEeV8yq9mjjs2t55ceIjLA9J9xzvSDFB3ACphvp0ST9lDoWCDGJZGyC0Jl4ubTnjeXKHjUGRilj1fLbJx1PlPAskkoWhCkpmLsE_4XQ")

                .body(query)
                .when().log().all()
                .post("/learn/graphql")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("data.users[0].name", equalTo("tui.glen"));

    }

    }

