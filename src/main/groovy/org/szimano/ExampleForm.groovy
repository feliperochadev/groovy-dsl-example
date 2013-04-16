package org.szimano

import static org.mockito.Mockito.mock

public abstract class ExampleForm<T> {

    def entity;
    def aClass;

    def output = new StringBuffer()

    ExampleForm(Class<T> aClass) {
        this.entity = giveMeObjectThatReturnsProperties(aClass)

        this.aClass = aClass;
    }

    def abstract formDefinition(T entity)

    def parse() {
        output << aClass.getName() << ":\n"

        formDefinition(entity)

        return output.toString()
    }

    def row(Object... fields) {
        output << "    -"
        fields.each { output << " $it" }
        output << "\n"
    }

    def section(String sectionName) {
        output << "  $sectionName:\n"
    }

    def table(String tableSectionName, Object field, List columns) {
        output << "  $tableSectionName:\n"
        output << "    field: $field\n"
        output << "    columns: [" << columns[0]

        for (def i = 1; i < columns.size(); i++) {
            output << ", " << columns[i]
        }

        output << "]\n"
    }

    def columns(columnClosure) {
        Class aClass = columnClosure.parameterTypes[0]

        return columnClosure(giveMeObjectThatReturnsProperties(aClass))
    }

    def giveMeObjectThatReturnsProperties(Class aClass) {
        def object = mock(aClass)

        object.metaClass.getProperty = {
            String propertyName -> return propertyName
        }

        return object;
    }
}