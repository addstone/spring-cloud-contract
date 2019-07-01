/*
 * Copyright 2013-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.contract.verifier.config;

import java.util.List;

import org.springframework.cloud.contract.verifier.config.framework.CustomDefinition;
import org.springframework.cloud.contract.verifier.config.framework.JUnit5Definition;
import org.springframework.cloud.contract.verifier.config.framework.JUnitDefinition;
import org.springframework.cloud.contract.verifier.config.framework.SpockDefinition;
import org.springframework.cloud.contract.verifier.config.framework.TestFrameworkDefinition;

/**
 * Contains main building blocks for a test class for the given framework.
 *
 * @author Jakub Kubrynski, codearte.io
 * @author Olga Maciaszek-Sharma
 *
 * @since 1.0.0
 */
public enum TestFramework {

	/**
	 * Spock test framework.
	 */
	SPOCK(new SpockDefinition()),
	/**
	 * JUnit test framework.
	 */
	JUNIT(new JUnitDefinition()),
	/**
	 * JUnit5 test framework.
	 */
	JUNIT5(new JUnit5Definition()),
	/**
	 * Custom test framework.
	 */
	CUSTOM(new CustomDefinition());

	private final TestFrameworkDefinition testFrameworkDefinition;

	TestFramework(TestFrameworkDefinition testFrameworkDefinition) {
		this.testFrameworkDefinition = testFrameworkDefinition;
	}

	/**
	 * @deprecated use{@link #TestFramework(TestFrameworkDefinition)}
	 * @param classModifier class modifier
	 * @param methodModifier method modifier
	 * @param lineSuffix line suffix
	 * @param classExtension class extension
	 * @param classNameSuffix class name suffix
	 * @param ignoreClass ignore class
	 * @param orderAnnotationImports order annotation imports
	 * @param orderAnnotation order annotation
	 */
	@Deprecated
	TestFramework(final String classModifier, final String methodModifier,
			final String lineSuffix, final String classExtension,
			final String classNameSuffix, final String ignoreClass,
			final List<String> orderAnnotationImports, final String orderAnnotation) {
		testFrameworkDefinition = new TestFrameworkDefinition() {
			@Override
			public String getClassModifier() {
				return classModifier;
			}

			@Override
			public String getMethodModifier() {
				return methodModifier;
			}

			@Override
			public String getLineSuffix() {
				return lineSuffix;
			}

			@Override
			public String getClassExtension() {
				return classExtension;
			}

			@Override
			public String getClassNameSuffix() {
				return classNameSuffix;
			}

			@Override
			public String getIgnoreClass() {
				return ignoreClass;
			}

			@Override
			public List<String> getOrderAnnotationImports() {
				return orderAnnotationImports;
			}

			@Override
			public String getOrderAnnotation() {
				return orderAnnotation;
			}

			@Override
			public String getIgnoreAnnotation() {
				return "@Ignore";
			}

			@Override
			public boolean annotationLevelRules() {
				return false;
			}

			@Override
			public String getRuleAnnotation(String annotationValue) {
				throw new UnsupportedOperationException("Not available in framework.");
			}

		};
	}

	public String getClassModifier() {
		return this.testFrameworkDefinition.getClassModifier();
	}

	public String getMethodModifier() {
		return this.testFrameworkDefinition.getMethodModifier();
	}

	public String getLineSuffix() {
		return this.testFrameworkDefinition.getLineSuffix();
	}

	public String getClassExtension() {
		return this.testFrameworkDefinition.getClassExtension();
	}

	public String getClassNameSuffix() {
		return this.testFrameworkDefinition.getClassNameSuffix();
	}

	public String getIgnoreClass() {
		return this.testFrameworkDefinition.getIgnoreClass();
	}

	public List<String> getOrderAnnotationImports() {
		return this.testFrameworkDefinition.getOrderAnnotationImports();
	}

	public String getOrderAnnotation() {
		return this.testFrameworkDefinition.getOrderAnnotation();
	}

	public String getIgnoreAnnotation() {
		return this.testFrameworkDefinition.getIgnoreAnnotation();
	}

	public boolean annotationLevelRules() {
		return this.testFrameworkDefinition.annotationLevelRules();
	}

	public String getRuleAnnotation(String annotationValue) {
		return this.testFrameworkDefinition.getRuleAnnotation(annotationValue);
	}

}
