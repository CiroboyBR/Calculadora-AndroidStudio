package com.example.a1app;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private TextView tela; //Tela do visor
    public double resultado = 0; //Variavel que recebera o resultado
    public String operacao = ""; //variavel que define qual será a operação
    public String termo1; //1 termo da operacao
    public String termo2 ; //2 termo da operacao


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tela = (TextView) findViewById(R.id.textView4);
        tela.setText("0"); //Seta o texto inicial do visor para 0
    }

    public void clicaBotao(View view) {
        String strtmp = new String(); //Variavel temporaria
        String s = new String(); //Variavel temporaria
        
        switch(view.getId()) {
            case R.id.buttonLimpa: //Botão Limpa
                operacao = "0";
                resultado = 0;
                tela.setText("0");
                break;
            case R.id.buttonMais: //Botão +
                operacao = "+";
                tela.setText(tela.getText()+"+"); //Se a string não terminar com
                break;
            case R.id.buttonMenos:
                operacao = "-";
                tela.setText(tela.getText()+"-");
                break;
            case R.id.buttonMultiplica:
                operacao = "*";
                tela.setText(tela.getText()+"*");
                break;
            case R.id.buttonDividir:
                operacao = "/";
                tela.setText(tela.getText()+"/");
                break;
            case R.id.buttonElevado:
                operacao = "^";
                tela.setText(tela.getText()+"^");
                break;

            case R.id.buttonIgual: //Botão = para calcular a operação
                calcular(tela.getText().toString());
                break;
            case R.id.buttonZero:
                if(tela.getText() == "0")
                    tela.setText("0");
                else
                    tela.setText(tela.getText()+"0");
                break;
            case R.id.buttonVirgula:
                if(tela.getText().toString().length() > 0 ) //se o tamanho da string é maior que 0
                    if(!tela.getText().toString().contains("."))  //se não contem um . no numero
                        tela.setText(tela.getText() + ".");
                    else { //Se ja contem casa decimal
                        if (tela.getText().toString().indexOf(operacao) > tela.getText().toString().indexOf(".")) { //verifica se a casa decimal é no primeiro termo, se for permite adicionar uma casa decimal no 2 termo
                            if (tela.getText().toString().indexOf(operacao) > tela.getText().toString().indexOf(".", tela.getText().toString().indexOf(operacao)))
                                tela.setText(tela.getText() + ".");
                        }
                        else if (tela.getText().toString().indexOf(operacao) < tela.getText().toString().indexOf(".")) //Se já existe uma casa decimal no segundo termo não adiciona outra
                            tela.setText(tela.getText());
                    }
                break;
            case R.id.buttonUm:
                if(tela.getText() == "0") //Se só existe o xero no visor
                    tela.setText("1"); //Insere o número no visor sobrescrevendo o zero
                else
                    tela.setText(tela.getText()+"1");
                break;
            case R.id.buttonDois:
                if(tela.getText() == "0")
                    tela.setText("2");
                else
                    tela.setText(tela.getText()+"2");
                break;
            case R.id.buttonTres:
                if(tela.getText() == "0")
                    tela.setText("3");
                else
                    tela.setText(tela.getText()+"3");
                break;
            case R.id.buttonQuatro:
                if(tela.getText() == "0")
                    tela.setText("4");
                else
                    tela.setText(tela.getText()+"4");
                break;
            case R.id.buttonCinco:
                if(tela.getText() == "0")
                    tela.setText("5");
                else
                    tela.setText(tela.getText()+"5");
                break;
            case R.id.buttonSeis:
                if(tela.getText() == "0")
                    tela.setText("6");
                else
                    tela.setText(tela.getText()+"6");
                break;
            case R.id.buttonSete:
                if(tela.getText() == "0")
                    tela.setText("7");
                else
                    tela.setText(tela.getText()+"7");
                break;
            case R.id.buttonOito:
                if(tela.getText() == "0")
                    tela.setText("8");
                else
                    tela.setText(tela.getText()+"8");
                break;
            case R.id.buttonNove:
                if(tela.getText() == "0")
                    tela.setText("9");
                else
                    tela.setText(tela.getText()+"9");
                break;
            default:
                break;

        }
    }

    //calcula o termo
    public void calcular(String op ) {

        String s;
        Double resultado = 0.0;

        termo1 = op.substring( 0, op.indexOf(operacao) ); //isola o 1 termo da operação matematica

        termo2 = op.substring( op.indexOf(operacao), op.length() ); //isola o 1 termo da operação matematica
        termo2 = termo2.substring( 1, termo2.length() ); //isola o 2 termo da operação matematica exluindo o sinal da operação

        if(operacao == "+") //se adição
            resultado = Double.parseDouble(termo1) + Double.parseDouble(termo2);
        else if(operacao == "-") //se subtrasção
            resultado = Double.parseDouble(termo1) - Double.parseDouble(termo2);
        else if(operacao == "*") //se multiplicação
            resultado = Double.parseDouble(termo1) * Double.parseDouble(termo2);
        else if(operacao == "/") //Se divisão
            resultado = Double.parseDouble(termo1) / Double.parseDouble(termo2);
        else if(operacao == "^") //se potenciação
            resultado = Math.pow(Double.parseDouble(termo1), Double.parseDouble(termo2));

        tela.setText( resultado.toString() );

    }


}