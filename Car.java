
public class Car {

	private String name; //車の名前
	private double fuelEfficiently; //燃費毎
	private double fuelTank; //タンク容量
	private double fuel; //現在のガソリン量毎
	private double addFuel; //追加ガソリン量
	private double decFuelCalc; //減らすガソリン量
	private double inputMove; //ガソリン現象計算用、ok判定通過後の入力された距離
	private double fuelCheck; //チェック用　現在ガソリン＋追加料
	private boolean ok_check; //ok判定用の付加数値
	private double move; //距離入力用
	private double checkMove; //走行可能距離

		public Car(String name, double fuelEfficiently, double fuelTank) {
			this.name = name;
			this.fuelEfficiently = fuelEfficiently;
			this.fuelTank = fuelTank;
			fuel +=10.0; //先生の解答は、this.fuel = 10;

			System.out.println("入力された設定を反映しました。\n");
			showSpec();

		}
		//車のスペックを表示する
		public void showSpec() {
			System.out.println("車の名前：\t\t" + name);
			System.out.println("燃費：\t\t\t" + fuelEfficiently + "[km/l]");
			System.out.println("タンク容量：\t" + fuelTank + "[l]");
			System.out.println("残燃料：\t\t" + fuel + "[l]");
		}
		// 給油入力処理関係まとめ
		public void getFuel() { //現在のタンク内の燃料残量
			double fuelTankRest = fuelTank - fuel; //給油可能量計算
			fuelTankRest = ((double)Math.round((fuelTankRest) * 10))/10;
			System.out.println("現在、タンク容量中：" + fuelTank + "[l]のうち、" + fuel +"[l]入っているので、");
			System.out.println(fuelTankRest + "[l]給油することが可能です。");

		}
		//実給油処理
		public void setFuel(double addFuel) {
			this.addFuel = addFuel; //
			fuel += addFuel; //燃料の判定必要

			//給油後に値を表示する（親切心）
			showSpec() ;
		}
		//減らすガソリン量計算 走行距離を貰って、計算してガソリン減らす。返さない。
		public void decFuel2(double inputMove) {
			this.inputMove = inputMove;
			double decFuel2a = inputMove / fuelEfficiently;
			fuel -= decFuel2a;
			fuel = ((double)Math.round((fuel) * 10))/10; //　四捨五入:計算結果に対して処理

			//給油後に値の表示更新
			showSpec();
		}
		//減らすガソリン量計算 走行距離を貰って、計算してガソリン減らす。返す。
		public double decFuelCalc(double inputMove) { //引数は距離
			this.inputMove = inputMove;
			double a =inputMove / fuelEfficiently;
			decFuelCalc = ((double)Math.round((a) * 10))/10;
			return decFuelCalc;

		}
		//給油可能計算と表示
		public void fuelTankRest() {
			double fuelTankRest = fuelTank - fuel;
			System.out.println("タンク容量中：" + fuelTank + "[l]のうち、" + fuelTankRest +"[l]入っています。\n");

		}
		//給油量確認メソッド
		public Object[] FuelCheck(double dValue2,Boolean ok) {
			this.addFuel = dValue2;
			this.ok_check = ok;
			this.fuelCheck = fuel + addFuel; //現在のガソリン量+追加ガソリン量

			// 現在ガソリン＋追加量 <= タンク ok判定
			if (fuelCheck <= fuelTank) {
				ok_check = true; //OK判定
				Object[] FuelCheckAnswer = {addFuel, ok_check}; //returnは１つしか返せないので配列に入れて返す
				return FuelCheckAnswer;
			}
			else {
				System.out.println("タンク容量オーバーです。");
				System.out.println("給油する量をタンク容量内で、半角数字で入力して下さい。");
				getFuel();
				ok_check = false; //NG判定
				Object[] FuelCheckAnswer = {addFuel, ok_check}; //returnは１つしか返せないので配列に入れて返す
				return FuelCheckAnswer;
			}
		}

		// 走行距離処理関係まとめ
		//走行可能距離計算
		public void checkMove() {
			checkMove = fuelEfficiently * fuel; //燃費 x 現在の搭載燃料
			checkMove = ((double)Math.round(checkMove * 10))/10; // 四捨五入:計算結果に対して処理
			System.out.println("走行可能距離は、" + checkMove + "[km]です。\n");
		}
		//移動可否判定、、燃費 x 残燃料 ＝ 走行可能距離
		public Object[] move(double move_i, Boolean ok) {
 			this.move = move_i;
 			this.ok_check = ok;

    		//moveCheck = 燃費 x 残燃料; 走行可能距離
    		double moveCheck = fuelEfficiently * fuel; //現在のガソリン量+追加ガソリン量
    		moveCheck = ((double)Math.round(moveCheck * 10))/10;  //四捨五入:計算結果に対して処理

			// 走行可能可否判定  入力された距離 <= moveCheck
			if (move <= moveCheck) {
				ok_check = true; //OK判定
				Object[] moveCheckAnswer = {move, ok_check}; //returnは１つしか返せないので配列に入れて返す
				return moveCheckAnswer; //
			}
			else {
				System.out.println("入力された走行距離に対して燃料が不足しています。");
				System.out.println("下記の走行可能距離を参考に、半角数字で入力して下さい。");
				System.out.println("走行可能距離は、" + checkMove + "[km]です。\n");
				ok_check = false; //NG判定
				Object[] moveCheckAnswer = {move, ok_check}; //returnは１つしか返せないので配列に入れて返す
				return moveCheckAnswer;

		}
	}
}
//double dValue = ((double)Math.round([value] * 10))/10; 四捨五入メモ
