using UnityEngine;
using System.Collections;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class UIManager : MonoBehaviour
{

    public Button[] buttons;
    public Text scoreText;
    int score;
    bool lost;
    private bool pause;
    // Use this for initialization

    public bool getIsPause()
    {
        return pause;
    }
    void Start()
    {
        score = 0;
        InvokeRepeating("updateScore", 1f, 0.5f);
        lost = false;
        pause = false;
    }

    // Update is called once per frame
    void Update()
    {
        if(scoreText != null)
            scoreText.text = "Score : " + score;
        if (Input.GetKeyUp(KeyCode.Space)/* && isKeySpaceDown*/)
        {
            Pause();
        }
    }

    public void Play()
    {
        SceneManager.LoadScene("Scene1");
    }

    public void Pause()
    {
        if (Time.timeScale == 1) //Means that the game is running
        {
            Time.timeScale = 0; // If Time.timeScale is 0 then the game is stopped./
            pause = true;
            Debug.Log("Dans UIManager - Pause: "+pause);
        }
        else
        {
            Time.timeScale = 1;
            pause = false;
        }
    }

    public void updateScore()
    {
        if (!lost)
            ++score;
    }

    public void youLost()
    {
        lost = true;
        foreach(Button b in buttons)
        {
            bool a = !b.isActiveAndEnabled;
            b.gameObject.SetActive(a);
        }
    }

    public void Replay()
    {
        //Application.LoadLevel(Application.loadedLevel);
        SceneManager.LoadScene(SceneManager.GetActiveScene().name);
    }
    public void MenuButton()
    {
        SceneManager.LoadScene("StartMenu");
    }
    public void Exit()
    {
        Application.Quit();
        Debug.Log("Application is quit");
    }
}
