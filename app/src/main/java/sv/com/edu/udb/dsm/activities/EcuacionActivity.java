
package sv.com.edu.udb.dsm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import sv.com.udb.dsm.R;

public class EcuacionActivity extends AppCompatActivity {

    public static final String EMPTY = "";
    private EditText componentA,componentB, componentC;
    private TextView x1, x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecuacion);
        componentA = findViewById(R.id.componentA);
        componentB = findViewById(R.id.componentB);
        componentC = findViewById(R.id.componentC);
        x1 = findViewById(R.id.x1);
        x2 = findViewById(R.id.x2);
    }

    public void resolveEcuation(View view){
        try{
            validateInput(componentA,componentB, componentC);
            float a = Integer.parseInt(componentA.getText().toString());
            float b = Integer.parseInt(componentB.getText().toString());
            float c = Integer.parseInt(componentC.getText().toString());
            if(a == 0){
                throw new Exception("\"A\" no puede ser 0");
            }
            //Se calcula el discriminante para verificar si tiene solucion real o imaginaria
            double discriminante = (b * b) - (4 * a * c);
            double sqrtVal = Math.sqrt(Math.abs(discriminante));
            String[] roots;
            if(discriminante >= 0){
                roots = realSolution(a,b,c,sqrtVal);
            }else {
                roots = imaginarySolution(a,b,c,sqrtVal);
            }
            printResult(roots);
        }catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void printResult(String[] roots){
        x1.setText(Html.fromHtml("X<sub>1</sup> : " + roots[0]));
        x2.setText(Html.fromHtml("X<sub>2</sup> : " + roots[1]));
    }

    private static String[] realSolution(float a, float b, float c, double d) {
        //-b+-sqrt(b^2-4ac) / 2a
        double x1  = (-b + d) / (2*a);
        double x2  = (-b - d) / (2*a);
        return new String[]{String.valueOf(x1), String.valueOf(x2)};
    }

    private static String[] imaginarySolution(float a,float b, float c, double d) {
        String x1 = -b / (2*a) + "+" +  d / (2*a)  + "i" ;
        String x2 = -b / (2*a) + "-" +  d / (2*a)  + "i" ;
        return new String[]{x1,x2};
    }

    private void validateInput(EditText... editTexts) throws Exception {
        for(EditText editText: editTexts) {
            String val = editText.getText().toString();
            if(EMPTY.equals(val)){
                throw new Exception(editText.getContentDescription().toString() + " no puede estar Vacio.");
            }
        }
    }
}