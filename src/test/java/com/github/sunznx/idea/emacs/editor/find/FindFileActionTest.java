package com.github.sunznx.idea.emacs.editor.find;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Tests for FindFileAction.
 */
class FindFileActionTest {

    @Test
    void shouldInstantiate() {
        FindFileAction action = new FindFileAction();
        assertNotNull(action, "Action should be instantiated");
    }
}
