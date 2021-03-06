/*
 * Copyright 2002-2016 Jalal Kiswani.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jk.faces.config;

import java.util.logging.Logger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class JKNamespace {
	private static int counter = 0;
	static Logger logger = Logger.getLogger(JKNamespace.class.getName());

	protected static String createPrefix(final String url) {
		return "xmlns:".concat(url.substring(url.length() - 3));
	}

	@XmlTransient
	Integer index = counter++;

	@XmlElement
	String prefix;

	@XmlElement
	String url;

	private String letter;

	public JKNamespace() {
	}

	public JKNamespace(final String url) {
		this(url, createPrefix(url));
	}

	public JKNamespace(final String url, final String prefix) {
		logger.info(String.format("create Namespace with url(%s) and Prefix(%s) ", url, prefix));
		this.url = url;
		this.prefix = prefix;
	}

	public Integer getIndex() {
		return this.index;
	}

	public String getLetter() {
		if (this.letter == null) {
			final String[] split = getPrefix().split(":");
			if (split.length == 2) {
				this.letter = split[1];
			} else {
				this.letter = split[0];
			}
		}
		return this.letter;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public String getUrl() {
		return this.url;
	}

	public void setPrefix(final String prefix) {
		this.prefix = prefix;
	}

	public void setUrl(final String url) {
		this.url = url;
	}
}
