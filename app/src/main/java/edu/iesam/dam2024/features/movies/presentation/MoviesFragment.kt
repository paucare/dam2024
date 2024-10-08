package edu.iesam.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.databinding.FragmentMoviesBinding
import edu.iesam.dam2024.features.movies.domain.Movie

class MoviesFragment : Fragment() {

    private lateinit var movieFactory : MovieFactory
    private lateinit var viewModel : MoviesViewModel

    //Esto hay que buscarlo en la documentacion

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        movieFactory = MovieFactory(requireContext())
        viewModel = movieFactory.buildViewModel()
        viewModel.viewCreated()
    }

    private fun setupObserver() {

        val movieObserver = Observer<MoviesViewModel.UiState> { uiState ->
            uiState.movies?.let {
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
        viewModel.uiState.observe(viewLifecycleOwner, movieObserver)
    }



    fun bindData(movies: List<Movie>){
        binding.movieId1.text = movies[0].id
        binding.movieTitle1.text = movies[0].title
        binding.layout1.setOnClickListener{
            findNavController().navigate()
        }

        binding.movieId1.text = movies[1].id
        binding.movieTitle1.text = movies[1].title
        binding.layout1.setOnClickListener{

        }


        binding.movieId1.text = movies[2].id
        binding.movieTitle1.text = movies[2].title
        binding.layout1.setOnClickListener{
            navigateToDetail(movies[2].id)
        }


        binding.movieId1.text = movies[3].id
        binding.movieTitle1.text = movies[3].title
        binding.layout1.setOnClickListener{
            navigateToDetail(movies[3].id)
        }

    }
    private fun navigateToDetail(movieId : String) {
        //val intent = Intent(this,MovieDetailActivity::class.java)
        startActivity(MovieDetailActivity.getIntent(requireContext(),movieId))
    }

    private fun showError(error : ErrorApp){
        when(error){
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp-> TODO()
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.UnkownErrorApp -> TODO()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}