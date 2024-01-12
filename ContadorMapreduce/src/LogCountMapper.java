import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


	public class LogCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	    private final static IntWritable one = new IntWritable(1);
	    private Text logType = new Text();

	    @Override
	    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
	        String line = value.toString();

	        // Verifica si la línea contiene el nombre de la aplicación
	        if (line.contains("wallet-rest-api")) {
	            // Extrae la etiqueta [INFO], [SEVERE] o [WARN]
	            String logLabel = extractLogLabel(line);
	            
	            // Si la etiqueta es válida, emite la pareja (etiqueta, 1)
	            if (logLabel != null && !logLabel.isEmpty()) {
	                logType.set(logLabel);
	                context.write(logType, one);
	            }
	        }
	    }

	    private String extractLogLabel(String line) {
	        // Implementa la lógica para extraer la etiqueta [INFO], [SEVERE] o [WARN] y devuelve la etiqueta o null si no se encuentra una etiqueta válida.
	        if (line.contains("[INFO]")) {
	            return "INFO";
	        } else if (line.contains("[SEVERE]")) {
	            return "SEVERE";
	        } else if (line.contains("[WARN]")) {
	            return "WARN";
	        } else {
	            return null;
	        }
	    }
	}

