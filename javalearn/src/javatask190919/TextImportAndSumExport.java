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
 */

private static void main(String[] args) {
	/**
	 * 処理を全て行なっているメソッド
	 * @param args 入力と出力のファイル名
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
			List<Integer> num = new ArrayList<Integer>();
			int sum = 0, target = 0;

			//テキストの読み込み中の行が空白
			while((data = br.readLine()) != null) {
				//1行テキストを数値に変換し読み込む
				num.add(Integer.parseInt(data));

				//変換した数値を合計値に足す
				sum += num.get(target);
				target += 1;
			}

			//テキストファイルに合計値を書き込む
			bw.write(String.valueOf(sum));
			bw.flush();

			//完了メッセージ
			System.out.println("出力が正常に終了しました");

			}catch(IOException e) {
				System.out.println("ファイル入出力に関するエラー");
				System.out.println(e);
			}finally {
				//読み込みと書き込みファイルを閉じる
				bw.close();
				br.close();
			}
		}catch(IOException e) {
			System.out.println("ファイル入出力に関するエラー");
			System.out.println(e);
		}catch(IllegalArgumentException e) {
			System.out.println("パラメータのエラー");
			System.out.println(e);
		}
	}
}
