/*
 * Copyright 2017 the original author or authors.
 *
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
 */

package org.springframework.cloud.stream.metrics.collector;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.boot.actuate.metrics.Metric;


/**
 * @author Vinicius Carvalho
 */
public class ApplicationMetrics {

	private String name;

	private String id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
	private final Date createdTime;

	private Collection<Metric> metrics;

	@JsonCreator
	public ApplicationMetrics(@JsonProperty("name") String name,
			@JsonProperty("id") String id,
			@JsonProperty("metrics") Collection<Metric> metrics) {
		this.name = name;
		this.id = id;
		this.metrics = metrics;
		this.createdTime = new Date();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Collection<Metric> getMetrics() {
		return metrics;
	}

	public void setMetrics(Collection<Metric> metrics) {
		this.metrics = metrics;
	}

	public Date getCreatedTime() {
		return createdTime;
	}


}
