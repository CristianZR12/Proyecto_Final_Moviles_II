package edu.memento.thedogapi.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import edu.memento.thedogapi.R
import edu.memento.thedogapi.intent.Intent
import edu.memento.thedogapi.ui.MainViewModel
import edu.memento.thedogapi.utils.AdaptersDog
import edu.memento.thedogapi.utils.DataState
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainFragment
constructor(
) : Fragment(R.layout.fragment_first) {

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var dogsAdapter: AdaptersDog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
//        viewModel.setStateEvent()
        val layoutManager =
                LinearLayoutManager(
                        requireActivity().applicationContext,
                        LinearLayoutManager.VERTICAL,
                        false
                )
        layoutManager.reverseLayout = true
        layoutManager.stackFromEnd = true
        recyclerViewDogs.layoutManager = layoutManager
        recyclerViewDogs.adapter = dogsAdapter

        subscribeObservers()
        lifecycleScope.launch {
            viewModel.userIntent.send(Intent.GetDogEvent)
        }
    }

    private fun subscribeObservers() {
        lifecycleScope.launch {
            viewModel.dataState.collect {
                when (it) {
                    is DataState.Success -> {
                        displayProgressBar(false)
//                    appendCatID(dataState.data)
                        dogsAdapter.setCats(it.dogs)
                    }
                    is DataState.Error -> {
                        displayProgressBar(false)
                        displayError(it.exception.message)
                    }
                    is DataState.Loading -> {
                        displayProgressBar(true)
                    }
                }
            }
        }
    }

    private fun displayError(message: String?) {
        //  if (message != null) text.text = message else text.text = "Unknown error."
    }


    private fun displayProgressBar(isDisplayed: Boolean) {
        progress_bar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }
}