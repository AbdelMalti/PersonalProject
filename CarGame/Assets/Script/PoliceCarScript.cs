using UnityEngine;
using System.Collections;

public class PoliceCarScript : MonoBehaviour {

    Vector2 actualPosition;
    private float speedOfTheCar = 3.0f;
    public float limitesHorizontale = 2.11f;
    public float limitesVertical = 4.38f;
    public float limitesJeu = -6f;

    // Use this for initialization
    void Start () {

	}
	
	// Update is called once per frame
	void Update () {
        transform.Translate(new Vector3(-1, 0, 0) * speedOfTheCar * Time.deltaTime);

        if (transform.position.y <= limitesJeu)
        {
            Destroy(gameObject);
        }
    }

   
}
