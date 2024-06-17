package ec.lang;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class IfElseTest {
    @BeforeAll
    public static void setup() throws IOException {
        BaseTest.preLoad();
    }

    @Test
    public void testIfElseElse() {
        String code = BaseTest.genStrippedCode("if (!true) { 1;} else if (false) {2;} else {3;}");
        assertNotNull(code);

        // @TODO FIXME assertTrue(code.indexOf("if (!true)") > -1);
        assertThat(code)
                .contains("if (true) {")
                .contains("} else if (false) {")
                .contains("} else {");
    }

    @Test
    public void testIfElseIf() {
        String code = BaseTest.genStrippedCode("if (!true) { 1;} else if (false) {2;}");
        assertNotNull(code);

        // @TODO FIXME assertTrue(code.indexOf("if (!true)") > -1);
        assertThat(code)
                .contains("if (true) {")
                .contains("} else if (false) {")
                .doesNotContain("} else {");
    }

    @Test
    public void testIfElse() {
        String code = BaseTest.genStrippedCode("if (!true) { 1;} else {2;}");
        assertNotNull(code);

        // @TODO FIXME assertTrue(code.indexOf("if (!true)") > -1);
        assertThat(code)
                .contains("if (true) {")
                .contains("} else {")
                .doesNotContain("else if");
    }

    @Test
    public void testIf() {
        String code = BaseTest.genStrippedCode("if (!true) { 1;}");
        assertNotNull(code);

        // @TODO FIXME assertTrue(code.indexOf("if (!true)") > -1);
        assertThat(code)
                .contains("if (true) { 1;}");
    }

    @Test
    public void testElseSyntaxError() {
        String code = BaseTest.genStrippedCode("else if (!true) { 1;}");
        assertNull(code);
        assertThat(BaseTest.errors)
                .hasSize(1)
                        .contains("[@0,0:3='else',<64>,1:0]");
    }

}