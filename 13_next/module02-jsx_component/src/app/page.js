import Link from "next/link";

export default function Home() {
  return (
    <>
     <h1>jsx_component</h1>
     <h3>chap01</h3>
     <ul>
      <li>
        <Link href="/chap01/section01">JSXIntro</Link>
      </li>
     </ul>
    </>
  );
}
