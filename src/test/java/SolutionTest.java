import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    final private Solution sol = new Solution();

    @Test
    void validTreeExample1() {
        assertTrue(sol.validTree(5, new int[][]{
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 4}
        }));
    }

    @Test
    void validTreeExample2() {
        assertFalse(sol.validTree(5, new int[][]{
                {0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}
        }));
    }
}