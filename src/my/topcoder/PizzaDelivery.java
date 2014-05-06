package my.topcoder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class PizzaDelivery {
	@SuppressWarnings("unused")
	public int deliverAll(String[] terrain) {
		
		
		RoutesMap map;
		
		for(int i=0;i<terrain.length;++i){
			String s = terrain[i];
			for (int j=1;j<s.length();++j) {
		
				
				Character x = s.charAt(j-1);
				Character y = s.charAt(j);
				int distance;
				if(Character.isDigit(x)&& Character.isDigit(y)){
					if(x.equals(y)){
						distance = 1;
					}else{
						int m = Integer.parseInt(String.valueOf(x));
						int n = Integer.parseInt(String.valueOf(y));
						if(Math.abs(m-n)<2){
							distance = 3;
						}else{
							distance = Integer.MAX_VALUE;
						}
						
					}
				}else{
					distance = 2;
				}
//				map.addDirectRoute(new City(Character.f), end, distance)
				
				
			}
		}
		return 0;
	}

	public final class Route implements Cloneable {
		// we need its concrete type to successfully clone this field
		private ArrayList<City> cities = new ArrayList<City>();

		private int distance = 0;

		/**
		 * Instances of this class are created by the {@link RouteBuilder}.
		 */
		Route() {
		}

		@SuppressWarnings("unchecked")
		public Route clone() {
			Route newInstance = null;

			try {
				newInstance = (Route) super.clone();
			} catch (CloneNotSupportedException cnfe) {
				// we are Cloneable: this should never happen
				assert false : cnfe;
			}

			newInstance.cities = (ArrayList<City>) cities.clone();

			return newInstance;
		}

		/**
		 * Add a new stop to this route with the given distance. If this is the
		 * first stop (i.e. the starting point), the <code>distance</code>
		 * argument is meaningless.
		 * 
		 * @param stop
		 *            the next city on this route.
		 * @param distance
		 *            the distance between the previous city and this one.
		 */
		void addStop(City stop, int distance) {
			if (!cities.isEmpty()) {
				this.distance += distance;
			}

			cities.add(stop);
		}

		/**
		 * @return the total distance of this route.
		 */
		public int getDistance() {
			return distance;
		}

		/**
		 * @return the number of stops on this route. The starting city is not
		 *         considered a stop and thus is not counted.
		 */
		public int getLength() {
			return (cities.isEmpty()) ? 0 : cities.size() - 1;
		}

		/**
		 * @return the last stop on this route. The last stop may be the
		 *         starting point if there are no other stops, or NULL is this
		 *         route has no stops.
		 */
		public City getLastStop() {
			if (cities.isEmpty()) {
				return null;
			} else {
				return cities.get(cities.size() - 1);
			}
		}

		/**
		 * @return whether this route goes through the given city.
		 */
		public boolean hasCity(City city) {
			return cities.contains(city);
		}

		public String toString() {
			StringBuffer temp = new StringBuffer();

			temp.append("l=").append(getLength()).append(" d=").append(
					getDistance()).append(" ").append(cities);

			return temp.toString();
		}
	}

	public class DijkstraEngine {
		/**
		 * Infinity value for distances.
		 */
		public static final int INFINITE_DISTANCE = Integer.MAX_VALUE;

		/**
		 * Some value to initialize the priority queue with.
		 */
		private static final int INITIAL_CAPACITY = 8;

		/**
		 * This comparator orders cities according to their shortest distances,
		 * in ascending fashion. If two cities have the same shortest distance,
		 * we compare the cities themselves.
		 */
		private final Comparator<City> shortestDistanceComparator = new Comparator<City>() {
			public int compare(City left, City right) {
				// note that this trick doesn't work for huge distances, close
				// to Integer.MAX_VALUE
				int result = getShortestDistance(left)
						- getShortestDistance(right);

				return (result == 0) ? left.compareTo(right) : result;
			}
		};

		/**
		 * The graph.
		 */
		private final RoutesMap map;

		/**
		 * The working set of cities, kept ordered by shortest distance.
		 */
		private final PriorityQueue<City> unsettledNodes = new PriorityQueue<City>(
				INITIAL_CAPACITY, shortestDistanceComparator);

		/**
		 * The set of cities for which the shortest distance to the source has
		 * been found.
		 */
		private final Set<City> settledNodes = new HashSet<City>();

		/**
		 * The currently known shortest distance for all cities.
		 */
		private final Map<City, Integer> shortestDistances = new HashMap<City, Integer>();

		/**
		 * Predecessors list: maps a city to its predecessor in the spanning
		 * tree of shortest paths.
		 */
		private final Map<City, City> predecessors = new HashMap<City, City>();

		/**
		 * Constructor.
		 */
		public DijkstraEngine(RoutesMap map) {
			this.map = map;
		}

		/**
		 * Initialize all data structures used by the algorithm.
		 * 
		 * @param start
		 *            the source node
		 */
		private void init(City start) {
			settledNodes.clear();
			unsettledNodes.clear();

			shortestDistances.clear();
			predecessors.clear();

			// add source
			setShortestDistance(start, 0);
			unsettledNodes.add(start);
		}

		/**
		 * Run Dijkstra's shortest path algorithm on the map. The results of the
		 * algorithm are available through {@link #getPredecessor(City)} and
		 * {@link #getShortestDistance(City)} upon completion of this method.
		 * 
		 * @param start
		 *            the starting city
		 * @param destination
		 *            the destination city. If this argument is
		 *            <code>null</code>, the algorithm is run on the entire
		 *            graph, instead of being stopped as soon as the destination
		 *            is reached.
		 */
		public void execute(City start, City destination) {
			init(start);

			// the current node
			City u;

			// extract the node with the shortest distance
			while ((u = unsettledNodes.poll()) != null) {
				assert !isSettled(u);

				// destination reached, stop
				if (u == destination)
					break;

				settledNodes.add(u);

				relaxNeighbors(u);
			}
		}

		/**
		 * Compute new shortest distance for neighboring nodes and update if a
		 * shorter distance is found.
		 * 
		 * @param u
		 *            the node
		 */
		private void relaxNeighbors(City u) {
			for (City v : map.getDestinations(u)) {
				// skip node already settled
				if (isSettled(v))
					continue;

				int shortDist = getShortestDistance(u) + map.getDistance(u, v);

				if (shortDist < getShortestDistance(v)) {
					// assign new shortest distance and mark unsettled
					setShortestDistance(v, shortDist);

					// assign predecessor in shortest path
					setPredecessor(v, u);
				}
			}
		}

		/**
		 * Test a node.
		 * 
		 * @param v
		 *            the node to consider
		 * 
		 * @return whether the node is settled, ie. its shortest distance has
		 *         been found.
		 */
		private boolean isSettled(City v) {
			return settledNodes.contains(v);
		}

		/**
		 * @return the shortest distance from the source to the given city, or
		 *         {@link DijkstraEngine#INFINITE_DISTANCE} if there is no route
		 *         to the destination.
		 */
		public int getShortestDistance(City city) {
			Integer d = shortestDistances.get(city);
			return (d == null) ? INFINITE_DISTANCE : d;
		}

		/**
		 * Set the new shortest distance for the given node, and re-balance the
		 * queue according to new shortest distances.
		 * 
		 * @param city
		 *            the node to set
		 * @param distance
		 *            new shortest distance value
		 */
		private void setShortestDistance(City city, int distance) {
			/*
			 * This crucial step ensures no duplicates are created in the queue
			 * when an existing unsettled node is updated with a new shortest
			 * distance.
			 * 
			 * Note: this operation takes linear time. If performance is a
			 * concern, consider using a TreeSet instead instead of a
			 * PriorityQueue. TreeSet.remove() performs in logarithmic time, but
			 * the PriorityQueue is simpler. (An earlier version of this class
			 * used a TreeSet.)
			 */
			unsettledNodes.remove(city);

			/*
			 * Update the shortest distance.
			 */
			shortestDistances.put(city, distance);

			/*
			 * Re-balance the queue according to the new shortest distance found
			 * (see the comparator the queue was initialized with).
			 */
			unsettledNodes.add(city);
		}

		/**
		 * @return the city leading to the given city on the shortest path, or
		 *         <code>null</code> if there is no route to the destination.
		 */
		public City getPredecessor(City city) {
			return predecessors.get(city);
		}

		private void setPredecessor(City a, City b) {
			predecessors.put(a, b);
		}

	}

	public final static class City implements Comparable<City> {
		/**
		 * The largest possible number of cities.
		 */
		public static final int MAX_NUMBER = 250;

		private static final City[] cities = new City[MAX_NUMBER];

		static {
			// initialize all City objects
			for (char c = 'A'; c <= 'Z'; c++) {
				cities[getIndexForName(c)] = new City(c);
			}
		}

		private static int getIndexForName(char name) {
			return name - 'A';
		}

		private static char getNameForIndex(int index) {
			return (char) ('A' + index);
		}

		public static final City A = City.valueOf('A');
		public static final City B = City.valueOf('B');
		public static final City C = City.valueOf('C');
		public static final City D = City.valueOf('D');
		public static final City E = City.valueOf('E');
		public static final City F = City.valueOf('F');

		public static City valueOf(char name) {
			if (name < 'A' || name > 'Z') {
				throw new IllegalArgumentException("Invalid city name: " + name);
			}

			return cities[getIndexForName(name)];
		}

		/*
		 * Package members only.
		 */
		static City valueOf(int n) {
			if (n < 0 || n > 25) {
				throw new IllegalArgumentException("Invalid city number: " + n);
			}

			return valueOf(getNameForIndex(n));
		}

		private final char name;

		/**
		 * Private constructor.
		 * 
		 * @param name
		 */
		private City(char name) {
			this.name = name;
		}

		public char getName() {
			return name;
		}

		/*
		 * Package members only.
		 */
		int getIndex() {
			return getIndexForName(name);
		}

		/**
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return String.valueOf(name);
		}

		/**
		 * Two cities are considered equal if they are the same object, or their
		 * names are the same.
		 * 
		 * @see java.lang.Object#equals(Object)
		 */
		public boolean equals(Object o) {
			return this == o || equals((City) o);
		}

		private boolean equals(City c) {
			return this.name == c.name;
		}

		/**
		 * Compare two cities by name.
		 * 
		 * @see java.lang.Comparable#compareTo(Object)
		 */
		public int compareTo(City c) {
			return this.name - c.name;
		}
	}

	public interface RoutesMap {
		/**
		 * Enter a new segment in the graph.
		 */
		public void addDirectRoute(City start, City end, int distance);

		/**
		 * Get the value of a segment.
		 */
		public int getDistance(City start, City end);

		/**
		 * Get the list of cities that can be reached from the given city.
		 */
		public List<City> getDestinations(City city);

		/**
		 * Get the list of cities that lead to the given city.
		 */
		public List<City> getPredecessors(City city);

		/**
		 * @return the transposed graph of this graph, as a new RoutesMap
		 *         instance.
		 */
		public RoutesMap getInverse();
	}
}
