using UnityEngine;
using System.Collections;

public class MovingCar : MonoBehaviour
{

    Vector2 actualPosition;
    public float speedOfTheCar = 8.0f;
    public float limitesHorizontale = 2.11f;
    public float limitesVertical = 4.38f;
    public UIManager uInterface;
    public AudioManager audioM;
    bool onMobile = false;

    private bool isCarAudioPlayed;

    // Use this for initialization
    void Start()
    {
        actualPosition = transform.position;
        audioM.carAudio.Play();
        isCarAudioPlayed = true;

        if (onMobile)
            Debug.Log("On Mobile");
        else
            Debug.Log("Not on Mobile");

        Debug.Log("car pos began: " + actualPosition);
    }

    public void Awake()
    {
        #if UNITY_ANDROID
            onMobile = true;
        #endif
    }

    // Update is called once per frame
    void Update()
    {
        if (onMobile &&  Input.touchCount > 0)
        {
            // Debug.Log(" Nombre de fois toucher : "+Input.touchCount);
            //Debug.Log("Position of touche"+ Input.GetTouch(0).position);
            //actualPosition = Input.GetTouch(0).position;

            var userInput = Camera.main.ScreenToWorldPoint(Input.GetTouch(0).position);

            if (Input.GetTouch(0).phase == TouchPhase.Began)
            {   
                actualPosition = userInput;
            }
        if(Input.GetTouch(0).phase == TouchPhase.Moved)
            {
                actualPosition = userInput;
            }
        if(Input.GetTouch(0).phase == TouchPhase.Ended)
            {
                Debug.Log("touched ended");
            }
            
        }
        else
        {
            actualPosition.x += Input.GetAxis("Horizontal") * speedOfTheCar * Time.deltaTime;
            actualPosition.y += Input.GetAxis("Vertical") * speedOfTheCar * Time.deltaTime;
            
        }
        
        //Servent a limiter le deplacement de la voiture.
        actualPosition.x = Mathf.Clamp(actualPosition.x, -limitesHorizontale, limitesHorizontale);
        actualPosition.y = Mathf.Clamp(actualPosition.y, -limitesVertical, limitesVertical);
        
        //Modifie la position de la voiture
        transform.position = actualPosition;

        if (uInterface.getIsPause() && isCarAudioPlayed)
        {
            audioM.carAudio.Pause();
            isCarAudioPlayed = false;
        }
        else if (!uInterface.getIsPause() && !isCarAudioPlayed)
        {
            audioM.carAudio.Play();
            isCarAudioPlayed = true;
        }
    }

    void OnCollisionEnter2D(Collision2D col)
    {
        if (col.collider.tag == "Ennemie car")
        {
            audioM.carAudio.Stop();
            audioM.carCrash.Play();
            Destroy(gameObject);
            uInterface.youLost();
        }
    }
}
