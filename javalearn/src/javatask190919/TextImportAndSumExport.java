package javatask190919;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextImportAndSumExport {
/**
 * コマンドライン引数で渡されたファイル名のテキストファイルを読み込み、<br>
 * その中の総和を算出するプログラム
 * @author Shinnosuke Ooe
 * @version 1.0
 * @param args 入力ファイル名　出力ファイル名　以上の2つをこの順序で用意
 */

public static void main(String[] args) {
	/**
	 * 処理を全て行なっているメソッド
	 */

	try {
		//パラメータ数が2個である事を確認
		if(args.length != 2) {
			throw new IllegalArgumentException("パラメータ数が過不足しています。パラメータは2個用意してください");
		}
		//ファイルが存在する事を確認
		File file = new File(args[0]);
		if(!file.exists()) {
			throw new IOException("ファイルが存在しません");
		}
		//読み込みオブジェクトの作成
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		//書き込みオブジェクトの生成
		File result = new File(args[1]);
		result.createNewFile();
		FileWriter fw = new FileWriter(result);
		BufferedWriter bw = new BufferedWriter(fw);
		try {
			String data;
			List<String> num = new ArrayList<String>();
			int sum = 0, target = 0;

			try{
				//テキストの読み込み中の行が空白
				while((data = br.readLine()) != null) {
					//1行テキストを数値に変換し読み込む
					num.add(data);

					//変換した数値を合計値に足す

					sum += Integer.parseInt(num.get(target));
					target += 1;
				}
			}
			catch(IllegalArgumentException e) {
				System.out.println("数値以外または許可されない数値がテキストに含まれています");
				System.out.println("エラーメッセージ：" + e);
				System.exit(1);
			}

			//テキストファイルに合計値を書き込む
			bw.write(String.valueOf(sum));
			bw.flush();

			//完了メッセージ
			System.out.println("出力が正常に終了しました");

			}catch(IOException e) {
				System.out.println("ファイル入出力に関するエラー");
				System.out.println("エラーメッセージ：" + e);
			}finally {
				//読み込みと書き込みファイルを閉じる
				bw.close();
				br.close();
			}
		}catch(IOException e) {
			System.out.println("ファイル入出力に関するエラー");
			System.out.println("エラーメッセージ：" + e);
		}catch(IllegalArgumentException e) {
			System.out.println("パラメータのエラー");
			System.out.println("エラーメッセージ：" + e);
		}
	}
}
