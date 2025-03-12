import java.util.Scanner;

public class RunwayReservation
{
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt(); // The total number of requests.
		int k = kb.nextInt(); // Grace time between requests.

		// Variables for getting the input.
		char cmd;
		int time;
		int curtime = 0; // Current time, initialized to 0.

		// An array of requests. This is the data stored outside of our binary search tree.
		Request[] reqs = new Request[n];
		int i = 0;

		// Reading the input. All requests are read from the input file and stored in array reqs.
		while(kb.hasNext())
		{
			cmd = kb.next().charAt(0);
			time = kb.nextInt();

			if (cmd == 'r')
			{
				String flightname = kb.next();
				String flightnumber = kb.next();
				String source = kb.next();
				String destination = kb.next();

				reqs[i++] = new Request('r', time, flightname, flightnumber, source, destination);
			}
			else
			{
				reqs[i++] = new Request('t', time);
			}
			kb.nextLine();
		}

		// TODO: Complete the runway reservation system.
		BST flights = new BST(); //Binary Search Tree
		Node lastFlight = null; 
		//Iterate through reqs
		for (int j = 0; j < reqs.length; j++)
		{
			//if reqs[i].command == i
			if (reqs[j].command == 'r')
			{
				//if grace is good or surrounding elements do no exist
				if ((flights.succ(reqs[j].time) == null || ((flights.succ(reqs[j].time)).time - reqs[j].time >= k))
					&& (flights.pred(reqs[j].time) == null || (reqs[j].time - (flights.pred(reqs[j].time)).time >= k))
					&& reqs[j].time > curtime
					&& (lastFlight == null || reqs[j].time - lastFlight.time >=k))
				{
					//insert reqs[i] into bst
					flights.insert(reqs[j].time, reqs[j]);
				}
					
			}
			else
			{
				//else advance time
				curtime += reqs[j].time;
				System.out.println("Current time = " + curtime + " units");
				for (Node p = flights.min(); p != null && p.time < curtime; p = flights.succ(p.time))
				{
					//if (p.time + k < curtime)
					//{
						lastFlight = p;
						System.out.println(p.req.airline);
						flights.delete(p.time);
					//}
				}
			}
		}
		curtime = flights.max().time;
		System.out.println("Current time = " + curtime + " units");
		for (Node p = flights.min(); p != null && p.time <= curtime; p = flights.succ(p.time))
		{
			System.out.println(p.req.airline);
			flights.delete(p.time);
		}
	}
}
