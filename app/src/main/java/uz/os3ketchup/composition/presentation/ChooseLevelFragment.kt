package uz.os3ketchup.composition.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.os3ketchup.composition.R
import uz.os3ketchup.composition.databinding.FragmentChooseLevelBinding
import java.util.logging.Level

class ChooseLevelFragment : Fragment() {

    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseLevelBinding==null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {


            btnTest.setOnClickListener { launchGameFragment(uz.os3ketchup.composition.domain.entity.Level.TEST) }
            btnEasy.setOnClickListener { launchGameFragment(uz.os3ketchup.composition.domain.entity.Level.EASY) }
            btnNormal.setOnClickListener { launchGameFragment(uz.os3ketchup.composition.domain.entity.Level.NORMAL) }
            btnHard.setOnClickListener { launchGameFragment(uz.os3ketchup.composition.domain.entity.Level.HARD) }

        }
    }

    private fun launchGameFragment(level: uz.os3ketchup.composition.domain.entity.Level) {
        /*
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container_main, GameFragment.newInstance(level))
                    .commit()
        */
        findNavController().navigate(ChooseLevelFragmentDirections.actionChooseLevelFragmentToGameFragment(level))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val name = "ChooseLevelFragment"
        fun newInstance(): ChooseLevelFragment {
            return ChooseLevelFragment()
        }
    }

}