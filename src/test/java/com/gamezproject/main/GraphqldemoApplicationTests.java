package com.gamezproject.main;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTest;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = GraphqldemoApplication.class)
class GraphqldemoApplicationTests {

	@Autowired
	private GraphQLTestTemplate graphQLTestTemplate;

	private static final String GRAPHQL_QUERY_RESQUEST = "request/recentPosts.query";
	private static final String GRAPHQL_QUERY_RESPONSE = "response/recentPosts.json";

	@Test
	void graphQlTest() throws IOException {
		String testName = "recentPosts";
		GraphQLResponse graphQLResponse = graphQLTestTemplate.postForResource(String.format(GRAPHQL_QUERY_RESQUEST, testName));

		Assertions.assertTrue(graphQLResponse.getStatusCode().is2xxSuccessful());

		String expectedResponseBody = readGraphQlJson(String.format(GRAPHQL_QUERY_RESPONSE, testName));

		Assertions.assertEquals(expectedResponseBody, graphQLResponse.getRawResponse().getBody());
	}

	private String readGraphQlJson(String location) throws IOException {
		return IOUtils.toString(new ClassPathResource(location).getInputStream(), StandardCharsets.UTF_8);
	}

}
