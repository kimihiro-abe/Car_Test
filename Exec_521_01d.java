
public class Exec_521_01d { //メインになるクラス。このコードから実行。

	//char cYN;
	static String YN1 = ""; //YesNo判定に使用
	static double i_Dbl; //数値入力用ダミー（中身はなし）
	static double p_Dbl1; //↑の返ってきた物を入れるよう
	static boolean ok; //↑数値入力のOK判定に使うboolean
	static Object[] p_Dbl2; // 異なる型を入れる用
	static double p_Dbl3; //数値入力最終判定用
	static boolean end;//ループ処理用

	public static void main(String[] args) throws InterruptedException {
		//カー設定　インスタンス生成後にshowSpecする
		Car car1 = new Car("モルカー", 10.0, 30.0); //インスタンス生成
		end = true; //ループ処理用

			//ループ開始位置
			do {
				//public void setOil_0() { //給油処理導入
				System.out.println();
				System.out.println("燃料を入れますか？(Y/N)");
				System.out.println("Nを選択した場合、走行距離入力に移ります。\n");

				//給油処理部分
				Input_Judge i_Judge1 = new Input_Judge(); //インスタンス生成　汎用input処理用
				switch(i_Judge1.JudgeYN(YN1)) { //YewNo判定をreturnで文字列貰って対応。
					case "Y":
						System.out.println();
						System.out.println("給油する量を、下記を参照し半角数字で入力して下さい。");
						car1.getFuel();
						System.out.println("(入力値は小数第二位で四捨五入されます。)\n");

						//数値入力判定
						do {
						p_Dbl1 = i_Judge1.inputDbl(i_Dbl); //汎用入力処理メソッドに投げreturnで返して貰う
						p_Dbl2 = car1.FuelCheck(p_Dbl1,ok); //給油量が可能かどうか確認する。p_Dbl2は配列
						p_Dbl3 = (double)p_Dbl2[0]; //p_Dbl3は、最終処理済みのデータ。
						ok = (boolean)p_Dbl2[1];

						} while ( ok != true);
						System.out.println("\n");
						System.out.println("給油を完了いたしました。\n");
						car1.setFuel(p_Dbl3); //ここで燃料をタンクに追加する。このメソッドにステータス表示機能あり
						System.out.println("\n");
						System.out.println("次に、走行距離入力に移ります。\n");

						break;
					case "N":
						System.out.println();
						System.out.println("走行距離入力に移ります。\n");
						break;

				}
				//走行距離入力
				System.out.println("走行しますか？(Y/N)");
				System.out.println("Nを選択した場合、テスト終了となります。\n");

				//走行処理とそれに伴うガソリン減少計算部分
				switch(i_Judge1.JudgeYN(YN1)) { //YewNo判定をreturnで文字列貰って対応。
					case "Y":
						System.out.println();
						System.out.println("走行距離を半角数字で入力して下さい。");
						System.out.println("入力値は小数第二位で四捨五入されます。（例：12.3");
						car1.checkMove(); //現在のガソリンで移動可能な距離を表示

						//数値入力判定
						do {
						p_Dbl1 = i_Judge1.inputDbl(i_Dbl); //汎用入力処理メソッドに投げreturnで返して貰う
						p_Dbl2 = car1.move(p_Dbl1,ok); //給油量が可能かどうか確認する。p_Dbl2は配列
						p_Dbl3 = (double)p_Dbl2[0]; // p_Dbl3は、最終処理済みのデータ
						ok = (boolean)p_Dbl2[1];

						} while ( ok != true);
						double decFuelCalc = car1.decFuelCalc(p_Dbl3); //↓の文で使う数値を得る処理
						System.out.println("入力された距離から計算して燃料" + decFuelCalc + "[l]を減らしました。\n");
						car1.decFuel2(p_Dbl3); //ここで燃料をタンクから引く。このメソッドにステータス表示機能あり
						System.out.println("再度、給油入力処理に戻ります。\n");

						//car1.showSpec(); //現在の車の状態を表示
						end = true;
						break;
					case "N":
						System.out.println();
						System.out.println("テスト用プログラムを終了します。\n");
						end = false;
						break;
				}
			} while (end == true);//ここまでをループ処理する。 whileは条件式がtrueの時に継続。

			//エンド処理
			Input_Judge i_Judge2 = new Input_Judge(); //インスタンス生成　汎用input処理用
			String text_s01 = "  お し ま い . . ." ;
			i_Judge2.Char_disp(text_s01);
	}
}

