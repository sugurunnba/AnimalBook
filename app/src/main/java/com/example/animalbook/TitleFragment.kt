package com.example.animalbook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.animalbook.databinding.FragmentTitleBinding

//Fragmentクラスを継承して作成
class TitleFragment : Fragment() {
//    val=定数, var=変数
    private var _binding: FragmentTitleBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        生成されたバインディングクラスに含まれるinflateメソッドを呼び出す
        _binding = FragmentTitleBinding.inflate(inflater, container, false)
//        取得したルートビューをonCreateViewの戻り値として返す
        return binding.root
    }

//    取得したバインディングクラスをonDestoryViewメソッドで破棄する
    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }

//    引数に指定した文字列をTextViewのtextプロパティに設定する
    fun setTitle(title: String){
        binding.titleText.text = title
    }
}