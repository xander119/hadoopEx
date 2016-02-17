import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AverageReducer extends
		Reducer<Text, IntWritable, Text, FloatWritable> {
	int sum = 0;
	Float count = 0f;
	Float ave = 0f;
	
	
	
	
	protected void reduce(Text key, Iterable<IntWritable> values,Context context) 
			throws IOException, InterruptedException {
		

		for (IntWritable v : values) {
			count ++;
			sum += v.get();
		}
		
	}
	protected void calAve(Context context) throws IOException, InterruptedException{
		ave = sum/count;
		context.write(new Text("Average"),new FloatWritable(ave));

	}
	
	
}
