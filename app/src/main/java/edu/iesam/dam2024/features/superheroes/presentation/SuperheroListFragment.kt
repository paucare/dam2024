package edu.iesam.dam2024.features.superheroes.presentation

import android.os.Bundle
import android.text.Layout.Directions
import androidx.lifecycle.ViewModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iesam.dam2024.databinding.FragmentSuperheroListBinding
import edu.iesam.dam2024.features.superheroes.domain.Superhero

class SuperheroListFragment: Fragment() {

    private lateinit var factory: SuperheroFactory
    private lateinit var viewModel: SuperheroListViewModel
    private lateinit var superheroAdapter: SuperheroAdapter

    private var _binding: FragmentSuperheroListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = SuperheroFactory(requireContext())
        viewModel= factory.getSuperheroListViewModel()
        setupObserver()
        viewModel.loadSuperHeroes()

    }

    private fun setupObserver() {
        val observer = Observer<SuperheroListViewModel.UiState> { uiState ->
            uiState.superheroes?.let { superheroes ->
                bindData(superheroes)
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    /*
    private fun bindData(superheroes: List<Superhero>) {
        binding.apply {
            superhero1.apply {
                text = superheroes[0].name
                setOnClickListener {
                    navigateToDetails(superheroes[0].id)

                }
            }
            superhero2.apply {
                text = superheroes[1].name
                setOnClickListener {
                    navigateToDetails(superheroes[1].id)

                }
            }
        }
    }

     */

    private fun bindData(superheroes : List<Superhero>){
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            superheroAdapter = SuperheroAdapter(superheroes) {
                superheroId ->        navigateToDetails(superheroId)
            }
            recyclerView.adapter = superheroAdapter
                /*
            recyclerView.adapter = SuperheroAdapter(superheroes) {
                superheroId ->        navigateToDetails(superheroId)    }

                 */
        }
    }

    private fun navigateToDetails(superheroId: String){
        findNavController().navigate(SuperheroListFragmentDirections
            .actionSuperheroToSuperheroDetail(superheroId))

    }
}