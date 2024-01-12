
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class LogCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    private IntWritable result = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        // Suma los valores para obtener el recuento total
        int sum = 0;
        for (IntWritable value : values) {
            sum += value.get();
        }
        result.set(sum);

        // Emite la pareja (etiqueta, recuento total)
        context.write(key, result);
    }
}

