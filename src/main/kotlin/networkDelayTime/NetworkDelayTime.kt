package networkDelayTime

class NetworkDelayTime {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val graph = times.groupBy { it.first() }.mapValues { (_, value) ->
            value.map { it[1] to it[2] }
        }
        val (dist, prev) = dijkstra(graph, n, k)

        return dist.maxOrNull()?.let {
            if (it == Int.MAX_VALUE) {
                -1
            } else {
                it
            }
        } ?: -1
    }

    private fun dijkstra(graph: Map<Int, List<Pair<Int, Int>>>, n: Int, start: Int): Pair<List<Int>, List<Int>> {
        val dist = IntArray(n + 1) { Int.MAX_VALUE }
        val prev = IntArray(n + 1) { -1 }
        dist[start] = 0
        val nodes = (1..n).toMutableList()
        while (nodes.isNotEmpty()) {
            val u = extractMin(nodes, dist)
            graph[u]?.forEach { (v, w) ->
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w
                    prev[v] = u
                }
            }
        }
        return dist.drop(1) to prev.drop(1)
    }

    private fun extractMin(nodes: MutableList<Int>, dist: IntArray): Int {
        var minNode = nodes[0]
        var minDistance = dist[0]

        nodes.forEach {
            if (dist[it] < minDistance) {
                minNode = it
                minDistance = dist[it]
            }
        }

        nodes.remove(minNode)
        return minNode
    }
}
