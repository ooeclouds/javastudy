package javatask190919;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextImportAndSumExport {
	/**
	 * コマンドライン引数で渡されたファイル名のテキストファイルを読み込み、<br>
	 * その中の総和を算出するプログラムです。
	 * @author Shinnosuke Ooe
	 * @param args
	 *
	 */

	private static void main(String[] args) {
		//パラメータ数が2個になっているか確認
		if(args.length != 2) {
			System.out.println("パラメータ数が過不足しています。パラメータは2個用意してください");
			System.exit(1);
		}



		try {
			//読み込みオブジェクトの作成
			File file = new File(args[0]);

			//ファイルチェック
			if(!file.exists()) {
				System.out.println("ファイルが存在しません");
			}

			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			//書き込みファイルの生成
			File result = new File(args[1]);
			result.createNewFile();



		}catch(IOException e) {

		}



	}


}
