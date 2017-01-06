using UnityEngine;
using System.Collections;

public class carSpawn : MonoBehaviour {

    public GameObject[] cars;
    public int carNumber;
    private int numOfElement;
    public float limitesHorizontale = 2f;
    public float limitesJeu = -5f;
    private float respondTime = 1f;
    private float timer;

    // Use this for initialization
    void Start () {
        timer = 0;
        numOfElement = cars.Length;
        //Debug.Log("numOfElement : " + numOfElement);
    }
	
	// Update is called once per frame
	void Update () {
//Debug.Log("Time : "+ timer);
        if (timer <= 0)
        {
            timer = respondTime;
            Vector3 carPostion = new Vector3(Random.Range(-limitesHorizontale, limitesHorizontale), transform.position.y, transform.position.z);
            carNumber = Random.Range(0, numOfElement);
            //Debug.Log("carNum : "+carNumber);
            Instantiate(cars[carNumber], carPostion, transform.rotation);
        }
        else
            timer -= Time.deltaTime;
        
        if (transform.position.y <= limitesJeu)
        {
            Destroy(gameObject);
            //Debug.Log("Position "+ transform.position.y);
        }
	}
}
