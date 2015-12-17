package pw.fib.sportbox.graph;

/**
 * Generator of paths between two nodes in graph
 */
public class PathGenerator {
    private final int[][] g;
    private final int n;

    private final int[] path;
    private int t;
    private int c;

    private int l;

    /**
     *
     * @param g - matrix of graph. Value 0 in cell [i][j] mean absence of arc.матрица графа. значение 0 в ячейке [i][j] обозначает отсутствие дуги
     * @param n - matrix size
     * @param f - first node
     * @param l - final node
     */
    public PathGenerator(int[][] g, int n, int f, int l) {
        this.g = g;
        this.n = n;

        this.path = new int[n];
        this.path[0] = f;
        this.t = 0;
        this.c = -1;

        this.l = l;
    }

    public boolean next() {
        loop: while (true) {
            c++;

            if (c == n) {
                if (t == 0)
                    return false; // обошли все возможные варианты

                c = path[t];
                t--;
                continue loop;
            }

            if (g[path[t]][c] == 0) // нет дуги от path[t] до c
                continue loop;

            for (int i = 0; i <= t; i++) // проверяем: вершины c нет в path
                if (path[i] == c)
                    continue loop;

            path[++t] = c;
            c = -1;

            if (path[t] == l)
                return true;
        }
    }

    public int[] path() {
        int[] path2 = new int[t+1];
        System.arraycopy(path, 0, path2, 0, path2.length);
        return path2;
    }

    public void skipTo(int j) {
        c = path[j+1];
        t = j;
    }
}
