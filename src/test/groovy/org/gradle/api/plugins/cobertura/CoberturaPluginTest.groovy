package org.gradle.api.plugins.cobertura

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification
import org.gradle.api.plugins.JavaPlugin

class CoberturaPluginTest extends Specification {
    Project project = ProjectBuilder.builder().build()

    def setup() {
        project.apply(plugin: CoberturaPlugin)
    }

    def "extensions are installed"() {
        expect:
        project.extensions.getByName("cobertura") instanceof CoberturaPluginExtension
    }

    def "when java plugin is applied test task is extended"() {
        when:
        project.apply(plugin: JavaPlugin)

        then:
        project.tasks.test.extensions.getByName("cobertura") instanceof CoberturaTestTaskExtension
    }
}
