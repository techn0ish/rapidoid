package org.rapidoid.http;

/*
 * #%L
 * rapidoid-integration-tests
 * %%
 * Copyright (C) 2014 - 2016 Nikolche Mihajlovski and contributors
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.junit.Test;
import org.rapidoid.annotation.Authors;
import org.rapidoid.annotation.GET;
import org.rapidoid.annotation.Since;
import org.rapidoid.u.U;
import org.rapidoid.web.On;

import java.util.List;

@Authors("Nikolche Mihajlovski")
@Since("5.1.0")
public class HttpBeanParamsTest extends HttpTestCommons {

	private static class Person {
		public int id;
		public String name;
	}

	@Test
	public void testBeanParams() {
		On.beans(new Object() {

			@GET
			@SuppressWarnings("unchecked")
			public List<Object> pers(String name, Person person, int id, Integer xx) {
				return U.list(id, name, person, xx);
			}

		});

		onlyGet("/pers?name=Einstein&id=1000");
		onlyGet("/pers?name=Mozart");
		onlyGet("/pers?id=200");
	}

}

