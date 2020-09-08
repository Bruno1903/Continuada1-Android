package com.example.app_continuada1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcularDesconto(componente:View){


        val bomDesconto = 70.0
        val medioDesconto = 40.0
        val porcentagem = et_input2.text.toString().toDouble()
        val valorProduto = et_input3.text.toString().toDouble()
        val nomeProduto = et_input1.text
        val divisao = porcentagem / 100
        val valorDescontado = valorProduto * divisao
        val resultado = valorProduto - valorDescontado

        if (nomeProduto.length > 18 || nomeProduto.length < 3){
            Toast.makeText(this, "Não existe produto com essa quantidade de letras!", Toast.LENGTH_LONG).show()
            tv_resultado.visibility = View.GONE
        }else if (valorProduto <= 0 || porcentagem <= 0){
            Toast.makeText(this, "Insira um valor maior que 0", Toast.LENGTH_LONG).show()
            tv_resultado.visibility = View.GONE
        }else if(porcentagem > 100){
            Toast.makeText(this, "Não existe desconto maior que 100%", Toast.LENGTH_LONG).show()
        }
        else{
            if (porcentagem < medioDesconto){
                tv_resultado.setTextColor(Color.RED)
            } else if (porcentagem >= medioDesconto && porcentagem < bomDesconto){
                tv_resultado.setTextColor(Color.GREEN)
            }else{
                tv_resultado.setTextColor(Color.BLUE)
            }
            tv_resultado.visibility = View.VISIBLE
        }

        tv_resultado.text = "Você irá pagar $resultado reais com esse desconto no $nomeProduto"


    }

}