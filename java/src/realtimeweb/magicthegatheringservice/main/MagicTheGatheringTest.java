package realtimeweb.magicthegatheringservice.main;

import realtimeweb.magicthegatheringservice.regular.MagicTheGatheringService;

public class MagicTheGatheringTest {

		public static void main(String[] args) throws Exception {
			MagicTheGatheringService mtgs = MagicTheGatheringService.getInstance();
			mtgs.connect();
			System.out.println(mtgs.searchCards("skeleton"));
		}
}
