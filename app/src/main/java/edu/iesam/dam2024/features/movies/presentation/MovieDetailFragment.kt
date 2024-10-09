package edu.iesam.dam2024.features.movies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.FragmentMovieDetailBinding
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieDetailFragment: Fragment() {

    private lateinit var movieFactory : MovieFactory
    private lateinit var viewModel : MovieDetailViewModel

    //Esto hay que buscarlo en la documentacion

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieDetailBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        movieFactory = MovieFactory(requireContext())
        viewModel = movieFactory.buildMovieDetailViewModel()
        setupObserver()
        viewModel.viewCreated(getMovieId()!!)
    }

    private fun setupObserver() {

        val movieDetailObserver = Observer<MovieDetailViewModel.UiState> { uiState ->
            uiState.movie?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                //pinto el error
            }
            if (uiState.isLoading) {
                //muestro el cargando...
                Log.d("@dev", "Cargando...")
            } else {
                //oculto el cargando...
                Log.d("@dev"," Cargado ...")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, movieDetailObserver)
    }



    private fun bindData(movie: Movie){
        val imageView = binding.posterDetail
        imageView.loadUrl(movie.poster)
        binding.titleDetail.text = movie.title
    }


    private fun showError(error : ErrorApp){
        when(error){
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp-> TODO()
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.UnkownErrorApp -> TODO()
        }
    }

    private fun getMovieId() : String? {
        return requireActivity().intent.getStringExtra(KEY_MOVIE_ID)
    }

    companion object {
        val KEY_MOVIE_ID = "key_movie_id"

        fun getIntent(context: Context, movieId : String): Intent {
            val intent = Intent(context,MovieDetailActivity::class.java)
            intent.putExtra(KEY_MOVIE_ID,movieId)
            return intent
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }}