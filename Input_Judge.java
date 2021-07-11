import java.util.InputMismatchException;
import java.util.Scanner;

public class Input_Judge { //汎用処理可能そうなものを別クラスにしました
	private static String YN; // YewNO判定
	private static String inputYN; //YewNO判定
	private static double i_Dbl;
	public String text;

	//YesNoの汎用処理メソッド
	public String JudgeYN(String YN1) {
		YN = YN1;
		Scanner sc = new Scanner(System.in);
		inputYN = sc.nextLine();

		YN = inputYN.toUpperCase(); //小文字でも大文字でも受けつける用処理

		if ("Y".equals(YN)) { //文字列が同じかの比較にはequals
			return "Y";
		}
		else if ("N".equals(YN)) {
			return "N";
		}
		else {
			System.out.println("入力に不備があるので、再入力をお願いします。");
			JudgeYN(YN); //このメソッドを再呼び出しして再入力。動くがこれでいいのか疑問。。。
			return "Z"; //何か返さないとエラーになってしまった。
		}

	}
	//double型入力の汎用処理メソッド
	public double inputDbl(double dbl) {
		i_Dbl = dbl;
		Scanner sc = new Scanner(System.in);

        try {
    		i_Dbl = sc.nextDouble();
    		if (i_Dbl < 0) {
    			System.out.println("マイナスの値が入力されました。");
    			System.out.println("再入力をお願いいたします。\n");
    			inputDbl(i_Dbl);
    		}
        } catch (InputMismatchException e) {
        	System.out.println("数値以外が入力されました。");
        	System.out.println("再入力をお願いいたします。\n");
        	inputDbl(i_Dbl);
        }
        //小数第二位で四捨五入したものを返す
		return ((double)Math.round(i_Dbl * 10))/10;
	}
	//遊びで入れたやつ エンド処理で使用
	public void Char_disp(String text) throws InterruptedException {
	    this.text = text;

		for (int i = 0; i < text.length(); i++) {
	    	System.out.print(text.charAt(i)); //教科書p143参照
			Thread.sleep(400);
		}

	}
}