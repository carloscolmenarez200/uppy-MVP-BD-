package com.developers.carlos.uppy;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.developers.carlos.uppy.utils.Email;

public class ContactoActivity extends AppCompatActivity{

    ProgressDialog pdialog = null;
    TextInputEditText tiNombre, tiEmail, tiMensaje;
    String destinatario, tema, mensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tiNombre = (TextInputEditText) findViewById(R.id.nombre);
        tiEmail = (TextInputEditText) findViewById(R.id.email);
        tiMensaje = (TextInputEditText) findViewById(R.id.mensaje);
    }


    public void onClickBtnEnviar(View v) {
        destinatario = tiEmail.getText().toString();
        tema = "Contacto Uppy";
        mensaje = "Hola, Sr(a) "+tiNombre.getText().toString() +
                    "gracias por contactarnos en su brevedad sera respodida su inquietud y/o solicitud"+
                    "\n Nombre: "+tiNombre.getText().toString()+
                    "\n Mensaje: "+tiMensaje.getText().toString();


        pdialog = ProgressDialog.show(this, "", "Enviando Mail...", true);

        RetreiveFeedTask task = new RetreiveFeedTask();
        task.execute();
    }

    class RetreiveFeedTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {

            return Email.enviarCorreo(destinatario,tema,mensaje);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            pdialog.dismiss();
            if(result){
                pdialog.dismiss();
                tiEmail.setText("");
                tiMensaje.setText("");
                tiNombre.setText("");
                Toast.makeText(getApplicationContext(), getString(R.string.email_exito), Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(), getString(R.string.email_fallido), Toast.LENGTH_LONG).show();

            }

        }
    }

}
