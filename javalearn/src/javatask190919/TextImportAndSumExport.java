package javatask190919;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TextImportAndSumExport {

	public static void main(String[] args) {
		try{
			//ファイル読み込みと書き込みのオブジェクト生成
			File file = new File("sumtext.txt");
			FileReader fr = new FileReader(file);
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(fr);
			BufferedReader inputname = new BufferedReader(isr);
			String data;
			String filename = null;
			//行ごとに数値として挿入するリストの作成
			List<Integer> num = new ArrayList<Integer>();
			//文書の最後まで行ごとに読み込み続ける
			while((data = br.readLine()) != null) {
				num.add(Integer.parseInt(data));
			}
			int sum =0;

			//読み込んだ数値の合計をsumに代入
			for(int adnum : num) {
				sum += adnum;
			}

			//ファイル名の入力
			System.out.println("ファイル名を入力してください\fin");
			filename = inputname.readLine();
			inputname.close();

			//リザルトファイル作成
			File result = new File(filename + ".txt");
			result.createNewFile();

			//書き込みオブジェクト生成
			FileWriter filew = new FileWriter(result);
			BufferedWriter bw = new BufferedWriter(filew);

			//ファイルの書き込み
			bw.write(String.valueOf(sum));

			//フラッシュとクローズ
			bw.flush();
			fr.close();
			bw.close();

			System.out.println("ファイル出力終了");

		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException ie) {
			System.out.println(ie);
		}

	}

}
