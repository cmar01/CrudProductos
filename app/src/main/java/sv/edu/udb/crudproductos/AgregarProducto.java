package sv.edu.udb.crudproductos;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import sv.edu.udb.crudproductos.datos.Producto;

public class AgregarProducto extends AppCompatActivity {
    EditText edtId, edtNombre, edtCategoria, edtDescripcion, edtStock, edtPrecio, edtImg;
    String key="",id="",nombre="",categoria="",descripcion="",stock="",img="",accion="";
    double precio = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_producto);
        inicializar();

    }

    private void inicializar() {
        edtId = findViewById(R.id.edtId);
        edtNombre = findViewById(R.id.edtNombre);
        edtCategoria = findViewById(R.id.edtCategoria);
        edtDescripcion = findViewById(R.id.edtDescripcion);
        edtStock = findViewById(R.id.edtEnStock);
        edtPrecio = findViewById(R.id.edtPrecio);
        edtImg = findViewById(R.id.edtImg);

        // Obtención de datos que envia actividad anterior
        Bundle datos = getIntent().getExtras();
        key = datos.getString("key");
        id = datos.getString("id");
        nombre=datos.getString("nombre");
        categoria=datos.getString("categoria");
        descripcion=datos.getString("descripcion");
        stock=datos.getString("enStock");
        precio =datos.getDouble("precio");
        img =datos.getString("img");
        accion=datos.getString("accion");

        edtId.setText(id);
        edtNombre.setText(nombre);
        edtCategoria.setText(categoria);
        edtDescripcion.setText(descripcion);
        edtStock.setText(stock);
        edtPrecio.setText(Double.toString(precio));
        edtImg.setText(img);
    }

    public void guardar(View v){
        String id = edtId.getText().toString();
        String nombre = edtNombre.getText().toString();
        String categoria = edtCategoria.getText().toString();
        String descripcion = edtDescripcion.getText().toString();
        String stock = edtStock.getText().toString();
        double precio = Double.parseDouble(edtPrecio.getText().toString());
        String img = edtImg.getText().toString();
        // Se forma objeto producto
        Producto producto = new Producto(id,nombre,categoria,descripcion,stock,precio,img);

        if (accion.equals("a")) { //Agregar usando push()
            ActividadProducto.refPersonas.push().setValue(producto);
        }
        else // Editar usando setValue
        {
            ActividadProducto.refPersonas.child(key).setValue(producto);
        }
        finish();
    }
    public void cancelar(View v){
        finish();
    }


}
